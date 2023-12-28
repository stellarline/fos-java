package org.stellarline.fos.client.core.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class ObjectContentCO implements Serializable {

    private String filename;

    private byte[] bytes;
}
