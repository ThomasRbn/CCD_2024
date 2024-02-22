<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20240222171647 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation DROP FOREIGN KEY FK_F4DD61D37ECF78B0');
        $this->addSql('DROP INDEX IDX_F4DD61D37ECF78B0 ON affectation');
        $this->addSql('ALTER TABLE affectation CHANGE cours_id atelier_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE affectation ADD CONSTRAINT FK_F4DD61D382E2CF35 FOREIGN KEY (atelier_id) REFERENCES atelier (id)');
        $this->addSql('CREATE INDEX IDX_F4DD61D382E2CF35 ON affectation (atelier_id)');
        $this->addSql('ALTER TABLE atelier DROP FOREIGN KEY FK_E1BB182382E2CF35');
        $this->addSql('DROP INDEX IDX_E1BB182382E2CF35 ON atelier');
        $this->addSql('ALTER TABLE atelier ADD nb_places INT NOT NULL, CHANGE atelier_id theme_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE atelier ADD CONSTRAINT FK_E1BB182359027487 FOREIGN KEY (theme_id) REFERENCES theme (id)');
        $this->addSql('CREATE INDEX IDX_E1BB182359027487 ON atelier (theme_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE affectation DROP FOREIGN KEY FK_F4DD61D382E2CF35');
        $this->addSql('DROP INDEX IDX_F4DD61D382E2CF35 ON affectation');
        $this->addSql('ALTER TABLE affectation CHANGE atelier_id cours_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE affectation ADD CONSTRAINT FK_F4DD61D37ECF78B0 FOREIGN KEY (cours_id) REFERENCES atelier (id)');
        $this->addSql('CREATE INDEX IDX_F4DD61D37ECF78B0 ON affectation (cours_id)');
        $this->addSql('ALTER TABLE atelier DROP FOREIGN KEY FK_E1BB182359027487');
        $this->addSql('DROP INDEX IDX_E1BB182359027487 ON atelier');
        $this->addSql('ALTER TABLE atelier DROP nb_places, CHANGE theme_id atelier_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE atelier ADD CONSTRAINT FK_E1BB182382E2CF35 FOREIGN KEY (atelier_id) REFERENCES theme (id)');
        $this->addSql('CREATE INDEX IDX_E1BB182382E2CF35 ON atelier (atelier_id)');
    }
}
