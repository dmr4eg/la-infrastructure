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
 * InvestmentData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class InvestmentData {

  private @Nullable BigDecimal initialInvestment;

  private @Nullable BigDecimal expenses;

  public InvestmentData initialInvestment(BigDecimal initialInvestment) {
    this.initialInvestment = initialInvestment;
    return this;
  }

  /**
   * Get initialInvestment
   * @return initialInvestment
   */
  @Valid 
  @Schema(name = "initialInvestment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initialInvestment")
  public BigDecimal getInitialInvestment() {
    return initialInvestment;
  }

  public void setInitialInvestment(BigDecimal initialInvestment) {
    this.initialInvestment = initialInvestment;
  }

  public InvestmentData expenses(BigDecimal expenses) {
    this.expenses = expenses;
    return this;
  }

  /**
   * Get expenses
   * @return expenses
   */
  @Valid 
  @Schema(name = "expenses", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expenses")
  public BigDecimal getExpenses() {
    return expenses;
  }

  public void setExpenses(BigDecimal expenses) {
    this.expenses = expenses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvestmentData investmentData = (InvestmentData) o;
    return Objects.equals(this.initialInvestment, investmentData.initialInvestment) &&
        Objects.equals(this.expenses, investmentData.expenses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialInvestment, expenses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvestmentData {\n");
    sb.append("    initialInvestment: ").append(toIndentedString(initialInvestment)).append("\n");
    sb.append("    expenses: ").append(toIndentedString(expenses)).append("\n");
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

