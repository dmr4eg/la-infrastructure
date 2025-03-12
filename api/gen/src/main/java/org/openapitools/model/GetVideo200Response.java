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
 * GetVideo200Response
 */

@JsonTypeName("getVideo_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-11T22:50:07.779870+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class GetVideo200Response {

  private @Nullable UUID videoUUID;

  private @Nullable String title;

  private @Nullable String description;

  private @Nullable String url;

  public GetVideo200Response videoUUID(UUID videoUUID) {
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

  public GetVideo200Response title(String title) {
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

  public GetVideo200Response description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetVideo200Response url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
   */
  
  @Schema(name = "url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    GetVideo200Response getVideo200Response = (GetVideo200Response) o;
    return Objects.equals(this.videoUUID, getVideo200Response.videoUUID) &&
        Objects.equals(this.title, getVideo200Response.title) &&
        Objects.equals(this.description, getVideo200Response.description) &&
        Objects.equals(this.url, getVideo200Response.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(videoUUID, title, description, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetVideo200Response {\n");
    sb.append("    videoUUID: ").append(toIndentedString(videoUUID)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

