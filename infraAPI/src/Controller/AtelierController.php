<?php

namespace App\Controller;

use App\Entity\Atelier;
use App\Repository\AtelierRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class AtelierController extends AbstractController
{
    #[Route('/api/atelier', name: 'atelier.get', methods: ['GET'])]
    public function get(AtelierRepository $atelierRepository): Response
    {
        $ateliers = $atelierRepository->findAll();
        $data = [];
        foreach ($ateliers as $atelier) {
            $data[] = $atelier->toArray();
        }
        return $this->json($data, Response::HTTP_OK);
    }

    #[Route('/api/atelier', name: 'atelier.post', methods: ['POST'])]
    public function post(EntityManagerInterface $manager, Request $request): Response
    {
        $data = json_decode($request->getContent(), true);
        $atelier = new Atelier();
        $atelier->updateAtelier($data['nom'], $data['theme'], $data['nbPlaces']);
        $manager->persist($atelier);
        $manager->flush();
        return $this->json($atelier->toArray(), Response::HTTP_CREATED);
    }

    #[Route('/api/atelier/theme', name: 'atelier.theme', methods: ['GET'])]
    public function getAtelierByTheme(AtelierRepository $atelierRepository, Request $request): Response
    {
        $data = json_decode($request->getContent(), true);
        $ateliers = $atelierRepository->findAtelierByThemeCode($data['theme']);
        $data = [];
        foreach ($ateliers as $atelier) {
            $data[] = $atelier->toArray();
        }
        return $this->json($data, Response::HTTP_OK);
    }
}
