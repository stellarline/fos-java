package org.stellarline.fos.client.core.model.request;

import com.alibaba.cola.dto.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BucketCreateReq extends Command {

    @NotBlank
    private String bucketName;

    private String encryptionType;

    @Size(min = 10)
    private Integer quotaSize;
}
