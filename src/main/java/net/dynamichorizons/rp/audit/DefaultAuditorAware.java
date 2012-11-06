package net.dynamichorizons.rp.audit;

import net.dynamichorizons.rp.domain.User;

import org.springframework.data.domain.AuditorAware;

public interface DefaultAuditorAware
    extends AuditorAware<User>
{

}
