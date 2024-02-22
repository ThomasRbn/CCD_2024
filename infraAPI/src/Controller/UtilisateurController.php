<?php

namespace App\Controller;

use App\Entity\Utilisateur;
use App\Repository\UtilisateurRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Attribute\Route;

class UtilisateurController extends AbstractController
{
    #[Route('api/utilisateurs', name: 'user.get', methods: ['GET'])]
    public function index(UtilisateurRepository $utilisateurRepository): JsonResponse
    {
        $utilisateurs = $utilisateurRepository->findAll();
        $data = [];
        foreach ($utilisateurs as $utilisateur) {
            $data[] = $utilisateur->toArray();
        }

        return new JsonResponse($data, 200);
    }

    #[Route('api/utilisateurs', name: 'user.post', methods: ['POST'])]
    public function post(Request $request, EntityManagerInterface $entityManager): JsonResponse
    {
        $data = json_decode($request->getContent(), true);
        $utilisateur = new Utilisateur();
        $utilisateur->updateUtilisateur($data['nom'], $data['prenom'], $data['email'], $data['voeux']);
        $entityManager->persist($utilisateur);
        $entityManager->flush();

        // Ajouter les en-têtes CORS
        $response = new JsonResponse($utilisateur->toArray(), 200);
        $response->headers->set('Access-Control-Allow-Origin', '*');
        $response->headers->set('Access-Control-Allow-Methods', 'GET');
        $response->headers->set('Access-Control-Allow-Headers', 'Content-Type');

        return $response;
    }
}
