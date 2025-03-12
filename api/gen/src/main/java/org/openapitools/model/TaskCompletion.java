package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TaskCompletion
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskCompletion implements UpdateTaskRequest {

  private @Nullable UUID taskUUID;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime completedDate;

  public TaskCompletion taskUUID(UUID taskUUID) {
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

  public TaskCompletion completedDate(OffsetDateTime completedDate) {
    this.completedDate = completedDate;
    return this;
  }

  /**
   * Get completedDate
   * @return completedDate
   */
  @Valid 
  @Schema(name = "completedDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completedDate")
  public OffsetDateTime getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(OffsetDateTime completedDate) {
    this.completedDate = completedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskCompletion taskCompletion = (TaskCompletion) o;
    return Objects.equals(this.taskUUID, taskCompletion.taskUUID) &&
        Objects.equals(this.completedDate, taskCompletion.completedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskUUID, completedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskCompletion {\n");
    sb.append("    taskUUID: ").append(toIndentedString(taskUUID)).append("\n");
    sb.append("    completedDate: ").append(toIndentedString(completedDate)).append("\n");
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

