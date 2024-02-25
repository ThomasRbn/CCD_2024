<?php

namespace App\Entity;

use ApiPlatform\Metadata\ApiResource;
use ApiPlatform\Metadata\Get;
use App\Controller\ThemeController;
use App\Repository\ThemeRepository;
use Doctrine\ORM\Mapping as ORM;

#[ApiResource(
    operations: [
        new Get(
            uriTemplate: '/api/theme',
            controller: ThemeController::class,
            output: Theme::class,
            name: 'theme.get'
        )
    ]
)]
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

    public function updateTheme(string $nom, string $code): void
    {
        $this->nom = !$nom ? $this->nom : $nom;
        $this->code = !$code ? $this->code : $code;
    }

    public function toArray(): array
    {
        return [
            'id' => $this->id,
            'nom' => $this->nom,
            'code' => $this->code
        ];
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

}
