package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Budget
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class Budget {

  private @Nullable Float totalFunds;

  private @Nullable Float allocated;

  public Budget totalFunds(Float totalFunds) {
    this.totalFunds = totalFunds;
    return this;
  }

  /**
   * Get totalFunds
   * @return totalFunds
   */
  
  @Schema(name = "totalFunds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalFunds")
  public Float getTotalFunds() {
    return totalFunds;
  }

  public void setTotalFunds(Float totalFunds) {
    this.totalFunds = totalFunds;
  }

  public Budget allocated(Float allocated) {
    this.allocated = allocated;
    return this;
  }

  /**
   * Get allocated
   * @return allocated
   */
  
  @Schema(name = "allocated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("allocated")
  public Float getAllocated() {
    return allocated;
  }

  public void setAllocated(Float allocated) {
    this.allocated = allocated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Budget budget = (Budget) o;
    return Objects.equals(this.totalFunds, budget.totalFunds) &&
        Objects.equals(this.allocated, budget.allocated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalFunds, allocated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Budget {\n");
    sb.append("    totalFunds: ").append(toIndentedString(totalFunds)).append("\n");
    sb.append("    allocated: ").append(toIndentedString(allocated)).append("\n");
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

