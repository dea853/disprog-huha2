
package com.ubaya.disprog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for displayReservasi complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="displayReservasi"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="namaPelanggan" type="{http://disprog.ubaya.com/}pelanggan" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="namaRestoran" type="{http://disprog.ubaya.com/}mitraResto" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="tanggalPemesanan" type="{http://disprog.ubaya.com/}date" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="jumlahOrang" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "displayReservasi", propOrder = {
    "namaPelanggan",
    "namaRestoran",
    "tanggalPemesanan",
    "jumlahOrang"
})
public class DisplayReservasi {

    protected Pelanggan namaPelanggan;
    protected MitraResto namaRestoran;
    protected Date tanggalPemesanan;
    protected int jumlahOrang;

    /**
     * Gets the value of the namaPelanggan property.
     * 
     * @return
     *     possible object is
     *     {@link Pelanggan }
     *     
     */
    public Pelanggan getNamaPelanggan() {
        return namaPelanggan;
    }

    /**
     * Sets the value of the namaPelanggan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pelanggan }
     *     
     */
    public void setNamaPelanggan(Pelanggan value) {
        this.namaPelanggan = value;
    }

    /**
     * Gets the value of the namaRestoran property.
     * 
     * @return
     *     possible object is
     *     {@link MitraResto }
     *     
     */
    public MitraResto getNamaRestoran() {
        return namaRestoran;
    }

    /**
     * Sets the value of the namaRestoran property.
     * 
     * @param value
     *     allowed object is
     *     {@link MitraResto }
     *     
     */
    public void setNamaRestoran(MitraResto value) {
        this.namaRestoran = value;
    }

    /**
     * Gets the value of the tanggalPemesanan property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getTanggalPemesanan() {
        return tanggalPemesanan;
    }

    /**
     * Sets the value of the tanggalPemesanan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setTanggalPemesanan(Date value) {
        this.tanggalPemesanan = value;
    }

    /**
     * Gets the value of the jumlahOrang property.
     * 
     */
    public int getJumlahOrang() {
        return jumlahOrang;
    }

    /**
     * Sets the value of the jumlahOrang property.
     * 
     */
    public void setJumlahOrang(int value) {
        this.jumlahOrang = value;
    }

}
