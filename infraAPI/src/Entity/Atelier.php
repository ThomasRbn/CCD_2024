<?php

namespace App\Entity;

use App\Repository\AtelierRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: AtelierRepository::class)]
class Atelier
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\ManyToOne(inversedBy: 'atelier')]
    private ?Theme $theme = null;

    #[ORM\OneToMany(targetEntity: Affectation::class, mappedBy: 'atelier')]
    private Collection $affectations;

    #[ORM\Column]
    private ?int $nbPlaces = null;

    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    public function __construct()
    {
        $this->affectations = new ArrayCollection();
    }

    public function updateAtelier(string $nom, Theme $theme, int $nbPlaces): void
    {
        $this->nom = $nom;
        $this->theme = $theme;
        $this->nbPlaces = $nbPlaces;
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTheme(): ?Theme
    {
        return $this->theme;
    }

    public function setTheme(?Theme $theme): static
    {
        $this->theme = $theme;

        return $this;
    }

    /**
     * @return Collection<int, Affectation>
     */
    public function getAffectations(): Collection
    {
        return $this->affectations;
    }

    public function addAffectation(Affectation $affectation): static
    {
        if (!$this->affectations->contains($affectation)) {
            $this->affectations->add($affectation);
            $affectation->setAtelier($this);
        }

        return $this;
    }

    public function removeAffectation(Affectation $affectation): static
    {
        if ($this->affectations->removeElement($affectation)) {
            // set the owning side to null (unless already changed)
            if ($affectation->getAtelier() === $this) {
                $affectation->setAtelier(null);
            }
        }

        return $this;
    }

    public function getNbPlaces(): ?int
    {
        return $this->nbPlaces;
    }

    public function setNbPlaces(int $nbPlaces): static
    {
        $this->nbPlaces = $nbPlaces;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): static
    {
        $this->nom = $nom;

        return $this;
    }

    public function toArray(): array
    {
        $affectations = [];
        foreach($this->affectations as $affectation){
            $affectations[] = $affectation->toArray();
        }
        return [
            'id' => $this->id,
            'theme' => $this->theme->toArray(),
            'affectations' => $affectations,
            'nbPlaces' => $this->nbPlaces,
            'nom' => $this->nom,
        ];
    }
}
