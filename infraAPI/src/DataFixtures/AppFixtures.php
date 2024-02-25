<?php

namespace App\DataFixtures;

use App\Entity\Theme;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $nomsThemes = ['italienne', 'française', 'd\'Amérique du Sud', 'japonaise', 'grecque', 'orientale'];
        $codesThemes = ['IT', 'FR', 'MEX', 'JP', 'GR', 'OR'];

        for ($i = 0; $i < 6; $i++){
            $theme = new Theme();
            $theme->updateTheme('Cuisine ' . $nomsThemes[$i], $codesThemes[$i]);
            $manager->persist($theme);
        }
        $manager->flush();
    }
}
