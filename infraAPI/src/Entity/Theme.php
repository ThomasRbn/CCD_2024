<?php

namespace App\Entity;

use App\Repository\ThemeRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: ThemeRepository::class)]
class Theme
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[ORM\Column(length: 10)]
    private ?string $code = null;

    #[ORM\OneToMany(targetEntity: Atelier::class, mappedBy: 'atelier')]
    private Collection $cours;

    public function __construct()
    {
        $this->cours = new ArrayCollection();
    }


    public function updateAtelier(string $nom, string $code): void
    {
        $this->nom = $nom;
        $this->code = $code;
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function getCode(): ?string
    {
        return $this->code;
    }

    public function toArray(): array
    {
        return [
            'id' => $this->id,
            'nom' => $this->nom,
            'code' => $this->code,
        ];
    }

    /**
     * @return Collection<int, Atelier>
     */
    public function getCours(): Collection
    {
        return $this->cours;
    }

    public function addCours(Atelier $cour): static
    {
        if (!$this->cours->contains($cour)) {
            $this->cours->add($cour);
            $cour->setAtelier($this);
        }

        return $this;
    }

    public function removeCours(Atelier $cour): static
    {
        if ($this->cours->removeElement($cour)) {
            // set the owning side to null (unless already changed)
            if ($cour->getAtelier() === $this) {
                $cour->setAtelier(null);
            }
        }

        return $this;
    }

}
