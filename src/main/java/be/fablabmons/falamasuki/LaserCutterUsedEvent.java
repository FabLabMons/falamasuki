package be.fablabmons.falamasuki;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LaserCutterUsedEvent {
  @Id @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String institution;
  @Enumerated(EnumType.STRING)
  private UserCategory category;
  private String imputationAccount;
  @AttributeOverrides({
    @AttributeOverride(name = "material", column = @Column(name = "plank_material")),
    @AttributeOverride(name = "provided", column = @Column(name = "plank_provided")),
    @AttributeOverride(name = "lengthMillimeters", column = @Column(name = "plank_lengthMillimeters")),
    @AttributeOverride(name = "widthMillimeters", column = @Column(name = "plank_widthMillimeters")),
    @AttributeOverride(name = "thicknessMillimeters", column = @Column(name = "plank_thicknessMillimeters")),
  })
  private Plank plank;
  private int maxLaserPowerPercentage;
  private int usedMinutes;
}

