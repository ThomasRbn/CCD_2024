<?php

namespace App\Entity;

use App\Repository\AffectationRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: AffectationRepository::class)]
class Affectation
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\ManyToOne(inversedBy: 'affectations')]
    private ?Atelier $atelier = null;

    #[ORM\ManyToOne(inversedBy: 'affectations')]
    private ?Utilisateur $utilisateur = null;


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getAtelier(): ?Atelier
    {
        return $this->atelier;
    }

    public function setAtelier(?Atelier $atelier): static
    {
        $this->atelier = $atelier;

        return $this;
    }


    public function updateAffectation(Atelier $atelier, Utilisateur $utilisateur): void
    {
        $this->atelier = $atelier;
        $this->utilisateur = $utilisateur;
    }

    public function toArray()
    {
        return [
            'id' => $this->id,
            'atelier' => $this->atelier->toArray()
        ];
    }

    public function getUtilisateur(): ?Utilisateur
    {
        return $this->utilisateur;
    }

    public function setUtilisateur(?Utilisateur $utilisateur): static
    {
        $this->utilisateur = $utilisateur;

        return $this;
    }
}
