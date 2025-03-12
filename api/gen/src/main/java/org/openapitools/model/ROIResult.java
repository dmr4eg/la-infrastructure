package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ROIResult
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class ROIResult {

  private @Nullable BigDecimal roiPercentage;

  private @Nullable BigDecimal profit;

  public ROIResult roiPercentage(BigDecimal roiPercentage) {
    this.roiPercentage = roiPercentage;
    return this;
  }

  /**
   * Get roiPercentage
   * @return roiPercentage
   */
  @Valid 
  @Schema(name = "roiPercentage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("roiPercentage")
  public BigDecimal getRoiPercentage() {
    return roiPercentage;
  }

  public void setRoiPercentage(BigDecimal roiPercentage) {
    this.roiPercentage = roiPercentage;
  }

  public ROIResult profit(BigDecimal profit) {
    this.profit = profit;
    return this;
  }

  /**
   * Get profit
   * @return profit
   */
  @Valid 
  @Schema(name = "profit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profit")
  public BigDecimal getProfit() {
    return profit;
  }

  public void setProfit(BigDecimal profit) {
    this.profit = profit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ROIResult roIResult = (ROIResult) o;
    return Objects.equals(this.roiPercentage, roIResult.roiPercentage) &&
        Objects.equals(this.profit, roIResult.profit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roiPercentage, profit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ROIResult {\n");
    sb.append("    roiPercentage: ").append(toIndentedString(roiPercentage)).append("\n");
    sb.append("    profit: ").append(toIndentedString(profit)).append("\n");
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

