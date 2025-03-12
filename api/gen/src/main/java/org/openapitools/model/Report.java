package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Report
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class Report {

  private @Nullable UUID reportUUID;

  private @Nullable String reportType;

  private @Nullable String url;

  public Report reportUUID(UUID reportUUID) {
    this.reportUUID = reportUUID;
    return this;
  }

  /**
   * ID of the report
   * @return reportUUID
   */
  @Valid 
  @Schema(name = "reportUUID", example = "665c599d-5c8d-4d20-aaab-7ffaba150606", description = "ID of the report", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reportUUID")
  public UUID getReportUUID() {
    return reportUUID;
  }

  public void setReportUUID(UUID reportUUID) {
    this.reportUUID = reportUUID;
  }

  public Report reportType(String reportType) {
    this.reportType = reportType;
    return this;
  }

  /**
   * Get reportType
   * @return reportType
   */
  
  @Schema(name = "reportType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reportType")
  public String getReportType() {
    return reportType;
  }

  public void setReportType(String reportType) {
    this.reportType = reportType;
  }

  public Report url(String url) {
    this.url = url;
    return this;
  }

  /**
   * URL to download the generated file
   * @return url
   */
  
  @Schema(name = "url", description = "URL to download the generated file", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Report report = (Report) o;
    return Objects.equals(this.reportUUID, report.reportUUID) &&
        Objects.equals(this.reportType, report.reportType) &&
        Objects.equals(this.url, report.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reportUUID, reportType, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Report {\n");
    sb.append("    reportUUID: ").append(toIndentedString(reportUUID)).append("\n");
    sb.append("    reportType: ").append(toIndentedString(reportType)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

