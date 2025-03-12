package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * GetAllVideos200ResponseInner
 */

@JsonTypeName("getAllVideos_200_response_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class GetAllVideos200ResponseInner {

  private @Nullable UUID videoUUID;

  private @Nullable String title;

  public GetAllVideos200ResponseInner videoUUID(UUID videoUUID) {
    this.videoUUID = videoUUID;
    return this;
  }

  /**
   * ID of the video
   * @return videoUUID
   */
  @Valid 
  @Schema(name = "videoUUID", example = "665c599d-5c8d-4d20-aaab-7ffaba150606", description = "ID of the video", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("videoUUID")
  public UUID getVideoUUID() {
    return videoUUID;
  }

  public void setVideoUUID(UUID videoUUID) {
    this.videoUUID = videoUUID;
  }

  public GetAllVideos200ResponseInner title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAllVideos200ResponseInner getAllVideos200ResponseInner = (GetAllVideos200ResponseInner) o;
    return Objects.equals(this.videoUUID, getAllVideos200ResponseInner.videoUUID) &&
        Objects.equals(this.title, getAllVideos200ResponseInner.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(videoUUID, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAllVideos200ResponseInner {\n");
    sb.append("    videoUUID: ").append(toIndentedString(videoUUID)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

