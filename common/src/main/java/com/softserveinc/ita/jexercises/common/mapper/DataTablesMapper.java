package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.dataTables.Columns;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.dto.dataTables.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * DataTables/SearchCondition mapping tool.
 *
 * @author Taras Vuyiv
 */
@Component
public class DataTablesMapper {
    /**
     * Maps DataTables object to SearchCondition.
     *
     * @param dataTables Grid data.
     * @return SearchCondition filter parameters.
     */
    public SearchCondition toSearchCondition(DataTables dataTables) {
        SearchCondition searchCondition = new SearchCondition();
        Map<String, String> filter = new HashMap<>();
        Map<String, String> orderBy = new HashMap<>();

        for (Order order : dataTables.getOrder()) {
            orderBy.put(dataTables.getColumns().get(order.getColumn())
                    .getData(), order.getDir());
        }

        if (!dataTables.getSearch().getValue().isEmpty()) {
            for (Columns column : dataTables.getColumns()) {
                if (column.isSearchable()) {
                    filter.put(column.getData(), dataTables.getSearch().getValue());
                }
            }
        }

        searchCondition.setFilterMap(filter);
        searchCondition.setOrderByMap(orderBy);
        searchCondition.setPageSize(dataTables.getLength());
        searchCondition.setPageNumber(
                dataTables.getStart() / dataTables.getLength());

        return searchCondition;
    }
}
