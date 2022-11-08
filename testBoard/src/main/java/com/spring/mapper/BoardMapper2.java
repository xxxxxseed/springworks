package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.domain.BoardVO2;

@Mapper
public interface BoardMapper2 {
	@Insert({"<script>",
			"INSERT INTO test_board(title, content)",
			"VALUES(#{title}, #{content})",
			"</script>"})
	int insertBoard(BoardVO2 boardVO2);
	
	@Select({"<script>",
			"SELECT * from test_board",
			"order by id desc",
			"</script>"})
	List<BoardVO2> findBoard();
	
	@Select({"<script>",
		"SELECT * from test_board",
		"where id = #{id}",
		"</script>"})
	BoardVO2 findOneBoard(int id);
}
