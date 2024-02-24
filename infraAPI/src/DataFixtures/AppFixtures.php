<?php

namespace App\DataFixtures;

use App\Entity\Atelier;
use App\Entity\Theme;
use App\Entity\Utilisateur;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $codes = ['IT', 'FR', 'MEX', 'JP', 'GR', 'OR'];
        $noms = ['italienne', 'française', 'd\'Amérique du Sud', 'japonaise', 'grecque', 'orientale'];
        $i = 0;
        $themes = [];
        foreach ($codes as $code) {
            $theme = new Theme();
            $theme->updateTheme('Cuisine ' . $noms[$i], $code);
            $themes[] = $theme;
            $manager->persist($theme);
            $i++;
        }

        for ($i = 0; $i < 5; $i++) {
            $theme = new Atelier();
            $theme->updateAtelier('Atelier ' . $i, $themes[rand(0, 5)], 10, 'Description de l\'atelier ' . $i);
            $manager->persist($theme);
        }



        // créer 4 utilisateurs de test
        for ($i = 0; $i < 4; $i++) {
            $utilisateur = new Utilisateur();

            //Create random array with theme
            $voeux = [];
            for ($j = 0; $j < 6; $j++) {
                $index = rand(0, 5);
                $voeux[] = $codes[$index];
            }

            $utilisateur->updateUtilisateur('utilisateur' . $i, 'utilisateur' . $i, 'utilisateur' . $i . '@gmail.com', $voeux);
            $manager->persist($utilisateur);
        }


        $manager->flush();
    }
}
