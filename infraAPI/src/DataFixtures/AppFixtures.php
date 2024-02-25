<?php

namespace App\DataFixtures;

use App\Entity\Atelier;
use App\Entity\Theme;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $nomsThemes = ['italienne', 'française', 'd\'Amérique du Sud', 'japonaise', 'grecque', 'orientale'];
        $codesThemes = ['IT', 'FR', 'MEX', 'JP', 'GR', 'OR'];

        $themes = [];
        for ($i = 0; $i < 6; $i++){
            $theme = new Theme();
            $theme->updateTheme('Cuisine ' . $nomsThemes[$i], $codesThemes[$i]);
            $themes[] = $theme;
            $manager->persist($theme);
        }

        for($i = 0; $i < 6; $i++){
            $atelier = new Atelier();
            $randomTheme = $themes[array_rand($themes)];
            $atelier->updateAtelier('Atelier ' . $i, $randomTheme, rand(5, 15));
            $manager->persist($atelier);
        }

        $manager->flush();
    }
}
