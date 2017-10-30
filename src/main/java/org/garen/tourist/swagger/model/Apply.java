package org.garen.tourist.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Apply
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-30T13:16:24.540Z")

public class Apply   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("sex")
  private String sex = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("itemName")
  private String itemName = null;

  public Apply name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 姓名
   * @return name
  **/
  @ApiModelProperty(value = "姓名")

 @Size(max=20)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Apply sex(String sex) {
    this.sex = sex;
    return this;
  }

   /**
   * 性别
   * @return sex
  **/
  @ApiModelProperty(value = "性别")

 @Size(max=1)
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Apply phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * 姓名
   * @return phone
  **/
  @ApiModelProperty(value = "姓名")

 @Size(max=11)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Apply itemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

   /**
   * 项目名
   * @return itemName
  **/
  @ApiModelProperty(value = "项目名")

 @Size(max=20)
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Apply apply = (Apply) o;
    return Objects.equals(this.name, apply.name) &&
        Objects.equals(this.sex, apply.sex) &&
        Objects.equals(this.phone, apply.phone) &&
        Objects.equals(this.itemName, apply.itemName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sex, phone, itemName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Apply {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
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

