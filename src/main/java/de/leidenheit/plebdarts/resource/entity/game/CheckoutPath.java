package de.leidenheit.plebdarts.resource.entity.game;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Entity
@Table(name = "checkout_path")
public class CheckoutPath {

    @Id
    private int score;
    private String path;

    public int getScore() {
        return score;
    }

    public String getPath() {
        return path;
    }
}
