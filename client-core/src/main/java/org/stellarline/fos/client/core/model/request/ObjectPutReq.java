package org.stellarline.fos.client.core.model.request;

import com.alibaba.cola.dto.Command;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ObjectPutReq extends Command {

    @NotBlank
    private String bucketName;

    @NotBlank
    private String objectPath;

    private String contentMD5;

    private String filename;
}
