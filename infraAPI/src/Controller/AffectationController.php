<?php

namespace App\Controller;

use App\Repository\AffectationRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Attribute\Route;

class AffectationController extends AbstractController
{
    #[Route('/api/affectation', name: 'app_affectation')]
    public function index(AffectationRepository $affectationRepository): JsonResponse
    {
        $affectations = $affectationRepository->findAll();
        $data = [];
        foreach ($affectations as $affectation) {
            $data[] = $affectation->toArray();
        }

        // Ajouter les en-têtes CORS
        $response = new JsonResponse($data, 200);
        $response->headers->set('Access-Control-Allow-Origin', '*');
        $response->headers->set('Access-Control-Allow-Methods', 'GET');
        $response->headers->set('Access-Control-Allow-Headers', 'Content-Type');

        return $response;
    }
}
