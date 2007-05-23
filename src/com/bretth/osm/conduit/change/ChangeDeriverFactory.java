package com.bretth.osm.conduit.change;

import java.util.Map;

import com.bretth.osm.conduit.pipeline.MultiSinkChangeSourceManager;
import com.bretth.osm.conduit.pipeline.TaskManager;
import com.bretth.osm.conduit.pipeline.TaskManagerFactory;


/**
 * The task manager factory for a change deriver.
 * 
 * @author Brett Henderson
 */
public class ChangeDeriverFactory extends TaskManagerFactory {
	private static final String TASK_TYPE = "derive-change";
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TaskManager createTaskManagerImpl(String taskId, Map<String, String> taskArgs, Map<String, String> pipeArgs) {
		return new MultiSinkChangeSourceManager(
			taskId,
			new ChangeDeriver(),
			pipeArgs
		);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTaskType() {
		return TASK_TYPE;
	}
}