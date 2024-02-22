<?php

namespace App\Controller;

use App\Entity\Atelier;
use App\Repository\AtelierRepository;
use App\Repository\ThemeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Doctrine\ORM\Mapping\Entity;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
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
        $response = new JsonResponse($data, 200);
        $response->headers->set('Access-Control-Allow-Origin', '*');
        $response->headers->set('Access-Control-Allow-Methods', 'GET');
        $response->headers->set('Access-Control-Allow-Headers', 'Content-Type');

        return $response;

    }

    #[Route('api/atelier', name: 'atelier.post', methods: ['POST'])]
    public function post(Request $request, EntityManagerInterface $entityManager, ThemeRepository $themeRepository): JsonResponse
    {
        $data = json_decode($request->getContent(), true);
        $atelier = new Atelier();
        $theme = $themeRepository->findOneBy(['code' => $data['theme']]);
        $atelier->updateAtelier($data['nom'], $theme, $data['nbPlaces'], $data['description']);
        $entityManager->persist($atelier);
        $entityManager->flush();

        return new JsonResponse($atelier->toArray(), 201);
    }
}
