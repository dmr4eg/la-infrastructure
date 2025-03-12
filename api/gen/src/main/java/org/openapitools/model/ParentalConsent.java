package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ParentalConsent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class ParentalConsent {

  private @Nullable Boolean isSigned;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime signedDate;

  public ParentalConsent isSigned(Boolean isSigned) {
    this.isSigned = isSigned;
    return this;
  }

  /**
   * Get isSigned
   * @return isSigned
   */
  
  @Schema(name = "isSigned", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isSigned")
  public Boolean getIsSigned() {
    return isSigned;
  }

  public void setIsSigned(Boolean isSigned) {
    this.isSigned = isSigned;
  }

  public ParentalConsent signedDate(OffsetDateTime signedDate) {
    this.signedDate = signedDate;
    return this;
  }

  /**
   * Get signedDate
   * @return signedDate
   */
  @Valid 
  @Schema(name = "signedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("signedDate")
  public OffsetDateTime getSignedDate() {
    return signedDate;
  }

  public void setSignedDate(OffsetDateTime signedDate) {
    this.signedDate = signedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParentalConsent parentalConsent = (ParentalConsent) o;
    return Objects.equals(this.isSigned, parentalConsent.isSigned) &&
        Objects.equals(this.signedDate, parentalConsent.signedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isSigned, signedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParentalConsent {\n");
    sb.append("    isSigned: ").append(toIndentedString(isSigned)).append("\n");
    sb.append("    signedDate: ").append(toIndentedString(signedDate)).append("\n");
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

