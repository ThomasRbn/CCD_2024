<?php

namespace App\Controller;

use App\Repository\AtelierRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class AtelierController extends AbstractController
{
    #[Route('api/atelier', name: 'atelier.get', methods: ['GET'])]
    public function index(AtelierRepository $atelierRepository): JsonResponse
    {
        $ateliers = $atelierRepository->findAll();
        $data = [];
        foreach ($ateliers as $atelier) {
            $data[] = $atelier->toArray();
        }

        // Ajouter les en-têtes CORS
        $response = new JsonResponse($data, Response::HTTP_OK);
        $response->headers->set('Access-Control-Allow-Origin', '*');
        $response->headers->set('Access-Control-Allow-Methods', 'GET');
        $response->headers->set('Access-Control-Allow-Headers', 'Content-Type');

        return $response;
    }
}
