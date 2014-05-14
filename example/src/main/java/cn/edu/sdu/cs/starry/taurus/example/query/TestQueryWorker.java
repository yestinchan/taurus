package cn.edu.sdu.cs.starry.taurus.example.query;

import cn.edu.sdu.cs.starry.taurus.common.exception.BusinessException;
import cn.edu.sdu.cs.starry.taurus.processor.QueryWorker;
import cn.edu.sdu.cs.starry.taurus.request.QueryRequest;
import cn.edu.sdu.cs.starry.taurus.response.QueryResponse;
import cn.edu.sdu.cs.starry.taurus.server.CacheTool;

public class TestQueryWorker extends QueryWorker {

	@Override
	protected void prepareWorker() {

	}

	@Override
	protected QueryResponse doWork(CacheTool cacheTool, QueryRequest query)
			throws BusinessException {
		TestQueryResponse response = new TestQueryResponse();
		response.setSayHello("this is a query ,saying hello "+ ((TestQueryRequest)query).getName());
		return response;
	}

	@Override
	protected void cleanProcessor() {

	}

	@Override
	public String getAuthor() {
		return "ytChen";
	}

}
