<?php

namespace App\DataFixtures;

use App\Entity\Atelier;
use App\Entity\Utilisateur;
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

        // créer 4 utilisateurs de test
        for ($i = 0; $i < 4; $i++) {
            $utilisateur = new Utilisateur();
            $utilisateur->updateUtilisateur('utilisateur' . $i, 'utilisateur' . $i . '@gmail.com', 'utilisateur' . $i);
            $manager->persist($utilisateur);
        }


        $manager->flush();
    }
}
