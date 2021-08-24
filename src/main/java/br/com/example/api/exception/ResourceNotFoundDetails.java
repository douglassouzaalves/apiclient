package br.com.example.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundDetails {
    private String title;
    private Integer status;
    private String details;
    private Long timestamp;
    private String developerMessage;


    public static final class ResourceNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String developerMessage;

        public static ResourceNotFoundDetailsBuilder newBuilder() {
            return new ResourceNotFoundDetailsBuilder();
        }

        public ResourceNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetailsBuilder details(String detail) {
            this.details = detail;
            return this;
        }

        public ResourceNotFoundDetailsBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.details = this.details;
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.developerMessage = this.developerMessage;
            resourceNotFoundDetails.status = this.status;
            return resourceNotFoundDetails;
        }
    }
}
