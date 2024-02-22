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
    private ?Atelier $cours = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getCours(): ?Atelier
    {
        return $this->cours;
    }

    public function setCours(?Atelier $cours): static
    {
        $this->cours = $cours;

        return $this;
    }
}
