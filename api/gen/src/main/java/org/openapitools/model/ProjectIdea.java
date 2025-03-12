package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProjectIdea
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class ProjectIdea {

  private @Nullable UUID ideaUUID;

  private @Nullable String ideaName;

  private @Nullable BigDecimal requiredInvestment;

  private @Nullable String productType;

  private @Nullable Integer teamSize;

  public ProjectIdea ideaUUID(UUID ideaUUID) {
    this.ideaUUID = ideaUUID;
    return this;
  }

  /**
   * ID of the project idea
   * @return ideaUUID
   */
  @Valid 
  @Schema(name = "ideaUUID", example = "665c599d-5c8d-4d20-aaab-7ffaba150606", description = "ID of the project idea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ideaUUID")
  public UUID getIdeaUUID() {
    return ideaUUID;
  }

  public void setIdeaUUID(UUID ideaUUID) {
    this.ideaUUID = ideaUUID;
  }

  public ProjectIdea ideaName(String ideaName) {
    this.ideaName = ideaName;
    return this;
  }

  /**
   * Get ideaName
   * @return ideaName
   */
  
  @Schema(name = "ideaName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ideaName")
  public String getIdeaName() {
    return ideaName;
  }

  public void setIdeaName(String ideaName) {
    this.ideaName = ideaName;
  }

  public ProjectIdea requiredInvestment(BigDecimal requiredInvestment) {
    this.requiredInvestment = requiredInvestment;
    return this;
  }

  /**
   * Get requiredInvestment
   * @return requiredInvestment
   */
  @Valid 
  @Schema(name = "requiredInvestment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requiredInvestment")
  public BigDecimal getRequiredInvestment() {
    return requiredInvestment;
  }

  public void setRequiredInvestment(BigDecimal requiredInvestment) {
    this.requiredInvestment = requiredInvestment;
  }

  public ProjectIdea productType(String productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
   */
  
  @Schema(name = "productType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productType")
  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public ProjectIdea teamSize(Integer teamSize) {
    this.teamSize = teamSize;
    return this;
  }

  /**
   * Get teamSize
   * @return teamSize
   */
  
  @Schema(name = "teamSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("teamSize")
  public Integer getTeamSize() {
    return teamSize;
  }

  public void setTeamSize(Integer teamSize) {
    this.teamSize = teamSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectIdea projectIdea = (ProjectIdea) o;
    return Objects.equals(this.ideaUUID, projectIdea.ideaUUID) &&
        Objects.equals(this.ideaName, projectIdea.ideaName) &&
        Objects.equals(this.requiredInvestment, projectIdea.requiredInvestment) &&
        Objects.equals(this.productType, projectIdea.productType) &&
        Objects.equals(this.teamSize, projectIdea.teamSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ideaUUID, ideaName, requiredInvestment, productType, teamSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectIdea {\n");
    sb.append("    ideaUUID: ").append(toIndentedString(ideaUUID)).append("\n");
    sb.append("    ideaName: ").append(toIndentedString(ideaName)).append("\n");
    sb.append("    requiredInvestment: ").append(toIndentedString(requiredInvestment)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    teamSize: ").append(toIndentedString(teamSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

