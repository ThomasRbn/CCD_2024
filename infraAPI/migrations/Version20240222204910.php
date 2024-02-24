<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20240222204910 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation ADD utilisateur_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE affectation ADD CONSTRAINT FK_F4DD61D3FB88E14F FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id)');
        $this->addSql('CREATE INDEX IDX_F4DD61D3FB88E14F ON affectation (utilisateur_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation DROP FOREIGN KEY FK_F4DD61D3FB88E14F');
        $this->addSql('DROP INDEX IDX_F4DD61D3FB88E14F ON affectation');
        $this->addSql('ALTER TABLE affectation DROP utilisateur_id');
    }
}
