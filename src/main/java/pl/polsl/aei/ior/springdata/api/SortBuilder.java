package pl.polsl.aei.ior.springdata.api;

import com.google.common.base.Preconditions;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;


public class SortBuilder {

    private final String sortField;
    private final String sortDirection;

    SortBuilder(String sortParam) {
        List<String> params = Arrays.asList(sortParam.split(","));
        Preconditions.checkArgument(params.size() == 2, "Incorrect sort parameter exception! Please check passed parameters");
        this.sortField = params.get(0);
        this.sortDirection = params.get(1);
    }

    Sort getSort() {
        try {
            SortType sortType = SortType.valueOf(sortDirection);
            if (sortType.equals(SortType.ASC)) {
                return Sort.by(sortField);
            }
            return Sort.by(sortField).descending();
        } catch (Exception ex) {
            throw new InvalidSortTypeException();
        }
    }

    enum SortType {
        ASC,
        DESC
    }

    static class InvalidSortTypeException extends RuntimeException {
        InvalidSortTypeException() {
            super("Incorrect sort parameter exception! Please check passed parameters");
        }
    }
}
