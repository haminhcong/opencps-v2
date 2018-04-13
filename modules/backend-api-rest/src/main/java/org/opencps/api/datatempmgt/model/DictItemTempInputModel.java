//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.30 at 11:56:43 AM ICT 
//


package org.opencps.api.datatempmgt.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.liferay.portal.kernel.util.StringPool;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dictItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dictCollectionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="itemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itemNameEN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="itemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="parentItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="treeIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="issueStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dictVersionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sibling" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="metaData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dictItemId",
    "companyId",
    "groupId",
    "userId",
    "createDate",
    "modifiedDate",
    "dictCollectionId",
    "itemCode",
    "itemName",
    "itemNameEN",
    "itemDescription",
    "parentItemId",
    "parentItemCode",
    "treeIndex",
    "issueStatus",
    "dictVersionId",
    "sibling",
    "level",
    "metaData",
    "status"
})
@XmlRootElement(name = "DictItemTempInputModel")
public class DictItemTempInputModel {

    protected long dictItemId;
    protected long companyId;
    protected long groupId;
    protected long userId;
    @XmlElement(required = true)
    protected String createDate;
    @XmlElement(required = true)
    protected String modifiedDate;
    protected long dictCollectionId;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "itemCode")
    protected String itemCode;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "itemName")
    protected String itemName;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "itemNameEN")
    protected String itemNameEN;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "itemDescription")
    protected String itemDescription;
    @DefaultValue("0") @FormParam(value = "parentItemId")
    protected long parentItemId;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "parentItemCode")
    protected String parentItemCode;
    @XmlElement(required = true)
    protected String treeIndex;
    protected int issueStatus;
    protected long dictVersionId;
    @DefaultValue("1") @FormParam(value = "sibling")
    protected long sibling;
    @DefaultValue("0") @FormParam(value = "level")
    protected int level;
    @XmlElement(required = true)
    @DefaultValue(StringPool.BLANK) @FormParam(value = "metaData")
    protected String metaData;
    @DefaultValue("1") @FormParam(value = "status")
    protected int status;

    /**
     * Gets the value of the dictItemId property.
     * 
     */
    public long getDictItemId() {
        return dictItemId;
    }

    /**
     * Sets the value of the dictItemId property.
     * 
     */
    public void setDictItemId(long value) {
        this.dictItemId = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     */
    public long getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     */
    public void setCompanyId(long value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     */
    public long getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     */
    public void setGroupId(long value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifiedDate(String value) {
        this.modifiedDate = value;
    }

    /**
     * Gets the value of the dictCollectionId property.
     * 
     */
    public long getDictCollectionId() {
        return dictCollectionId;
    }

    /**
     * Sets the value of the dictCollectionId property.
     * 
     */
    public void setDictCollectionId(long value) {
        this.dictCollectionId = value;
    }

    /**
     * Gets the value of the itemCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the value of the itemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCode(String value) {
        this.itemCode = value;
    }

    /**
     * Gets the value of the itemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the value of the itemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Gets the value of the itemNameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemNameEN() {
        return itemNameEN;
    }

    /**
     * Sets the value of the itemNameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemNameEN(String value) {
        this.itemNameEN = value;
    }

    /**
     * Gets the value of the itemDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Sets the value of the itemDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemDescription(String value) {
        this.itemDescription = value;
    }

    /**
     * Gets the value of the parentItemId property.
     * 
     */
    public long getParentItemId() {
        return parentItemId;
    }

    /**
     * Sets the value of the parentItemId property.
     * 
     */
    public void setParentItemId(long value) {
        this.parentItemId = value;
    }

    /**
     * Gets the value of the parentItemCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentItemCode() {
        return parentItemCode;
    }

    /**
     * Sets the value of the parentItemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentItemCode(String value) {
        this.parentItemCode = value;
    }

    /**
     * Gets the value of the treeIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreeIndex() {
        return treeIndex;
    }

    /**
     * Sets the value of the treeIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreeIndex(String value) {
        this.treeIndex = value;
    }

    /**
     * Gets the value of the issueStatus property.
     * 
     */
    public int getIssueStatus() {
        return issueStatus;
    }

    /**
     * Sets the value of the issueStatus property.
     * 
     */
    public void setIssueStatus(int value) {
        this.issueStatus = value;
    }

    /**
     * Gets the value of the dictVersionId property.
     * 
     */
    public long getDictVersionId() {
        return dictVersionId;
    }

    /**
     * Sets the value of the dictVersionId property.
     * 
     */
    public void setDictVersionId(long value) {
        this.dictVersionId = value;
    }

    /**
     * Gets the value of the sibling property.
     * 
     */
    public long getSibling() {
        return sibling;
    }

    /**
     * Sets the value of the sibling property.
     * 
     */
    public void setSibling(long value) {
        this.sibling = value;
    }

    /**
     * Gets the value of the level property.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Gets the value of the metaData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaData() {
        return metaData;
    }

    /**
     * Sets the value of the metaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaData(String value) {
        this.metaData = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

}
