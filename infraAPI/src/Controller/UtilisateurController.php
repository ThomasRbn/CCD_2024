<?php

namespace App\Controller;

use App\Repository\UtilisateurRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Attribute\Route;

class UtilisateurController extends AbstractController
{
    #[Route('api/utilisateurs', name: 'app_utilisateur', methods: ['GET'])]
    public function index(UtilisateurRepository $utilisateurRepository): JsonResponse
    {
        $utilisateurs = $utilisateurRepository->findAll();
        $data = [];
        foreach ($utilisateurs as $utilisateur) {
            $data[] = $utilisateur->toArray();
        }

        return new JsonResponse($data, 200);
    }
}
