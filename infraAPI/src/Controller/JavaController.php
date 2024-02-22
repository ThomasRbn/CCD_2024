<?php

namespace App\Controller;

use App\Entity\Affectation;
use App\Entity\Atelier;
use App\Repository\AtelierRepository;
use App\Repository\UtilisateurRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpClient\HttpClient;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class JavaController extends AbstractController
{
    #[Route('api/java', name: 'java.post', methods: ['POST'])]
    public function post(Request $request, EntityManagerInterface $entityManager, AtelierRepository $atelierRepository): JsonResponse
    {
        $data = json_decode($request->getContent(), true);
        $str1 = rtrim($data, ";");
        $str2 = rtrim($str1, "\n");

        $data = explode("\n", $str2);

        foreach ($data as $line) {
            $lineData = explode(";", $line);
            $prenom = $lineData[1];
            $codeAtelier = $lineData[2];

            $atelier = $atelierRepository->findOneBy(['code' => $codeAtelier]);
            $affectation = new Affectation();
            $affectation->updateAffectation($atelier, $prenom);
            $entityManager->persist($affectation);
        }

        $entityManager->flush();

        return new JsonResponse("Ok", 201);

    }
    #[Route('/api/java/envoi', name: 'app_java')]
    public function index(AtelierRepository $atelierRepository, UtilisateurRepository $utilisateurRepository, HttpClient $client): Response
    {
        $client->request('POST', 'http://docketu.iutnc.univ-lorraine.fr:8082/voeux', [
            'body' => $this->createCSV($atelierRepository, $utilisateurRepository)
        ]);
        return new JsonResponse("oui", 200);
    }

    public function createCSV(AtelierRepository $atelierRepository, UtilisateurRepository $utilisateurRepository): string
    {
        $ateliers = $atelierRepository->findAll();
        $csv = "ateliers;\n" .
            "id;theme;nb;\n";
        foreach ($ateliers as $atelier) {
            $csv .= $atelier->getId() . ";" . $atelier->getTheme()->getCode() . ";" . $atelier->getNbPlaces() . ";\n";
        }
        $csv .= "\n" .
            "candidats;\n" .
            "id;nom;nbDemande;ordre1;ordre2;ordre3;ordre4;ordre5;ordre6;\n";
        $utilisateurs = $utilisateurRepository->findAll();
        foreach ($utilisateurs as $utilisateur) {
            $csv .= $utilisateur->getId() . ";" . $utilisateur->getEmail() . ";" . count($utilisateur->getVoeux()) . ";" . $utilisateur->getVoeux()[0] . ";" . $utilisateur->getVoeux()[1] . ";" . $utilisateur->getVoeux()[2] . ";" . $utilisateur->getVoeux()[3] . ";" . $utilisateur->getVoeux()[4] . ";" . $utilisateur->getVoeux()[5] . ";\n";
        }
        return $csv;
    }
}
