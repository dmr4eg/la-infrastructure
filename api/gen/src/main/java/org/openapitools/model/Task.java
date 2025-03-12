package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Task
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class Task implements UpdateTaskRequest {

  private @Nullable UUID taskUUID;

  private @Nullable String name;

  private @Nullable Integer day;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    COMPLETED("completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable StatusEnum status;

  public Task taskUUID(UUID taskUUID) {
    this.taskUUID = taskUUID;
    return this;
  }

  /**
   * ID of the task
   * @return taskUUID
   */
  @Valid 
  @Schema(name = "taskUUID", example = "665c599d-5c8d-4d20-aaab-7ffaba150606", description = "ID of the task", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taskUUID")
  public UUID getTaskUUID() {
    return taskUUID;
  }

  public void setTaskUUID(UUID taskUUID) {
    this.taskUUID = taskUUID;
  }

  public Task name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Task day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
   */
  
  @Schema(name = "day", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("day")
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public Task status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.taskUUID, task.taskUUID) &&
        Objects.equals(this.name, task.name) &&
        Objects.equals(this.day, task.day) &&
        Objects.equals(this.status, task.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskUUID, name, day, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    taskUUID: ").append(toIndentedString(taskUUID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

