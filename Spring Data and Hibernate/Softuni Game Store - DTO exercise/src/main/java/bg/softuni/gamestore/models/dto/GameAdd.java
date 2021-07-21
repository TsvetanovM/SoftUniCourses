package bg.softuni.gamestore.models.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAdd {

    private String title;
    private BigDecimal price;
    private long size;
    private String trailer = "";
    private String thumbnailUrl;
    private String description;
    private LocalDate releaseDate;

    public GameAdd(String title, BigDecimal price, long size, String trailer, String thumbnailUrl, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Z](.+){2,99}", message = "Please enter a valid title!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Positive(message = "Price cannot be negative or 0!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive(message = "Size cannot be negative or 0!")
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Pattern(regexp = "https://www.youtube.com/.*v=([\\w]{11})", message = "The trailer must be a youtube video!")
//    @Pattern(regexp = "https:\\/\\/www.youtube.com\\/.*v=([\\w]{11})")
    public String getTrailer() {
        return trailer;
    }


    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "https:.+|http:.+", message = "Please enter a valid thumbnail URL!")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Size(min = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
