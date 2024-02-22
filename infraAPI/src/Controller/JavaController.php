<?php

namespace App\Controller;

use App\Entity\Affectation;
use App\Entity\Atelier;
use App\Repository\AtelierRepository;
use App\Repository\ThemeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
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

}
