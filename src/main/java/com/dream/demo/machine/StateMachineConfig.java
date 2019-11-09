package com.dream.demo.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Autowired
    private LeaveStateMachinePersist leaveStateMachinePersist;

    @Bean
    public StateMachinePersister<States, Events, String> stateMachinePersist() {
        return new DefaultStateMachinePersister<>(leaveStateMachinePersist);
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.WAITING_FOR_SUBMIT)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.WAITING_FOR_SUBMIT).target(States.WAITING_FOR_TL_APPROVE)
                .event(Events.SUBMIT)
                .action(new Action<States, Events>() {
                    @Override
                    public void execute(StateContext<States, Events> stateContext) {
                        System.out.println(stateContext.getEvent()+" "+stateContext.getStage());
                    }
                })
                .and()
                .withExternal()
                .source(States.WAITING_FOR_TL_APPROVE).target(States.WAITING_FOR_DM_APPROVE)
                .event(Events.TL_AGREE)
                .action(new Action<States, Events>() {
                    @Override
                    public void execute(StateContext<States, Events> stateContext) {
                        System.out.println("TL_AGREE" + stateContext.getMessage());
                    }
                })
                .and()
                .withExternal()
                .source(States.WAITING_FOR_TL_APPROVE).target(States.WAITING_FOR_SUBMIT)
                .event(Events.TL_REJECT)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_DM_APPROVE).target(States.WAITING_FOR_HR_RECORD)
                .event(Events.DM_AGREE)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_DM_APPROVE).target(States.WAITING_FOR_SUBMIT)
                .event(Events.DM_REJECT)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_HR_RECORD).target(States.END)
                .event(Events.HR_RECORD);
    }
}
