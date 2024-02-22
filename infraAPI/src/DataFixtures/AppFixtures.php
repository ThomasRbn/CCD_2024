<?php

namespace App\DataFixtures;

use App\Entity\Atelier;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $themes = ['IT', 'FR', 'MEX', 'JP', 'GR', 'OR'];
        $nom = ['italienne', 'française', 'd\'Amérique du Sud', 'japonaise', 'grecque', 'orientale'];
        $i = 0;
        foreach ($themes as $theme) {
            $atelier = new Atelier();
            $atelier->updateAtelier('Cuisine ' . $nom[$i], $theme);
            $manager->persist($atelier);
            $i++;
        }

        $manager->flush();
    }
}
