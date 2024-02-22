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

    #[ORM\OneToMany(targetEntity: Atelier::class, mappedBy: 'theme')]
    private Collection $atelier;

    public function __construct()
    {
        $this->atelier = new ArrayCollection();
    }


    public function updateTheme(string $nom, string $code): void
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
    public function getAtelier(): Collection
    {
        return $this->atelier;
    }

    public function addAtelier(Atelier $cour): static
    {
        if (!$this->atelier->contains($cour)) {
            $this->atelier->add($cour);
            $cour->setTheme($this);
        }

        return $this;
    }

    public function removeAtelier(Atelier $cour): static
    {
        if ($this->atelier->removeElement($cour)) {
            // set the owning side to null (unless already changed)
            if ($cour->getTheme() === $this) {
                $cour->setTheme(null);
            }
        }

        return $this;
    }

}
