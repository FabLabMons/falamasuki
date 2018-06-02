package be.fablabmons.falamasuki;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Plank {
  private String material;
  private boolean provided;
  private int lengthMillimeters;
  private int widthMillimeters;
  private int thicknessMillimeters;
}
