<?php

namespace App\Controller;

use App\Entity\Theme;
use App\Repository\ThemeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

class ThemeController extends AbstractController
{
    #[Route('/api/theme', name: 'theme.get', methods: ['GET'])]
    public function get(ThemeRepository $themeRepository): Response
    {
        $themes = $themeRepository->findAll();
        $data = [];
        foreach ($themes as $theme) {
            $data[] = $theme->toArray();
        }
        return $this->json($data);
    }

    #[Route('/api/theme', name: 'theme.post', methods: ['POST'])]
    public function post(EntityManagerInterface $manager, Request $request): Response
    {
        $data = json_decode($request->getContent(), true);
        $theme = new Theme();
        $theme->updateTheme($data['nom'], $data['code']);
        $manager->persist($theme);
        $manager->flush();
        return $this->json($theme->toArray());
    }
}
