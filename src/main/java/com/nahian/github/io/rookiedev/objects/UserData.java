package com.nahian.github.io.rookiedev.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserData {
    private String name;
    private String address;
    private String email;
    private String mobile;
}
