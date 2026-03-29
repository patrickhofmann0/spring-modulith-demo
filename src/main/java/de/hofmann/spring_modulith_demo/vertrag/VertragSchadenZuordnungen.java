package de.hofmann.spring_modulith_demo.vertrag;

import java.util.List;

public interface VertragSchadenZuordnungen {

    List<String> getSchaedenByVertragId(Long vertragId);
}
