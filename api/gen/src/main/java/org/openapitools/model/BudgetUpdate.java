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
 * BudgetUpdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class BudgetUpdate {

  private @Nullable BigDecimal totalFunds;

  private @Nullable BigDecimal allocated;

  public BudgetUpdate totalFunds(BigDecimal totalFunds) {
    this.totalFunds = totalFunds;
    return this;
  }

  /**
   * Get totalFunds
   * @return totalFunds
   */
  @Valid 
  @Schema(name = "totalFunds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalFunds")
  public BigDecimal getTotalFunds() {
    return totalFunds;
  }

  public void setTotalFunds(BigDecimal totalFunds) {
    this.totalFunds = totalFunds;
  }

  public BudgetUpdate allocated(BigDecimal allocated) {
    this.allocated = allocated;
    return this;
  }

  /**
   * Get allocated
   * @return allocated
   */
  @Valid 
  @Schema(name = "allocated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("allocated")
  public BigDecimal getAllocated() {
    return allocated;
  }

  public void setAllocated(BigDecimal allocated) {
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
    BudgetUpdate budgetUpdate = (BudgetUpdate) o;
    return Objects.equals(this.totalFunds, budgetUpdate.totalFunds) &&
        Objects.equals(this.allocated, budgetUpdate.allocated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalFunds, allocated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BudgetUpdate {\n");
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

