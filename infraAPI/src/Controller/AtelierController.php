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

        return new JsonResponse($data, Response::HTTP_OK);
    }
}
