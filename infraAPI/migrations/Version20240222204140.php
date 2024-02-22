<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20240222204140 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation DROP utilisateur');
        $this->addSql('ALTER TABLE utilisateur ADD affectation_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE utilisateur ADD CONSTRAINT FK_1D1C63B36D0ABA22 FOREIGN KEY (affectation_id) REFERENCES affectation (id)');
        $this->addSql('CREATE INDEX IDX_1D1C63B36D0ABA22 ON utilisateur (affectation_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation ADD utilisateur VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE utilisateur DROP FOREIGN KEY FK_1D1C63B36D0ABA22');
        $this->addSql('DROP INDEX IDX_1D1C63B36D0ABA22 ON utilisateur');
        $this->addSql('ALTER TABLE utilisateur DROP affectation_id');
    }
}
